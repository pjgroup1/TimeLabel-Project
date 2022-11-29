package com.javateam.TimeLabel.controller;

import com.javateam.TimeLabel.model.*;
import com.javateam.TimeLabel.model.session.SessionConst;
import com.javateam.TimeLabel.service.AdminService;
import com.javateam.TimeLabel.service.OrderService;
import com.javateam.TimeLabel.service.UserService;
import com.javateam.TimeLabel.util.UploadFileUtils;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;


    @Resource(name = "uploadPath")
    private String uploadPath;

    /* 관리자 메인 페이지 이동 */
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String adminMainGET() throws Exception {

        logger.info("#### 관리자 메인 페이지 이동 ####");

        return "admin/main";
    }


    // 상품 등록
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void getGoodsRegister(Model model) throws Exception {
        logger.info("get goods register");

        List<ProductCategoryVO> category = null; // CatagoryVO 형태의 List형 변수 category 선언
        category = adminService.category(); // DB에 저장된 카테고리를 가져와서 category에 저장
        logger.info("category = {}", category);
        model.addAttribute("category", JSONArray.fromObject(category)); // 변수 category를 제이슨(json)타입으로 변환하여 category 세션에


    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String adminProductInsert(HttpServletRequest request, ProductVO vo, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {


        String uploadPath2 = request.getServletContext().getRealPath("") + uploadPath;
        String imgUploadPath = uploadPath2 + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
        System.out.println("uploadPath2:" + uploadPath2);
        System.out.println("imgUloadPath:" + imgUploadPath);
        File dirPath = new File(imgUploadPath);
        if (!dirPath.exists())
            dirPath.mkdir();
        String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
        String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
        if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
            // 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)

            System.out.println("imgUploadPath:" + imgUploadPath);
            System.out.println("ymdPath:" + ymdPath);

            fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
            System.out.println("최종fileName:" + fileName);
            // gdsImg에 원본 파일 경로 + 파일명 저장
            vo.setProductMainImage(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
            // gdsThumbImg에 썸네일 파일 경로 + 썸네일 파일명 저장
            vo.setProductThumbImage(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
        }
        adminService.register(vo);

        return "redirect:/admin/main";
    }


    // 관리자용 상품리스트
    @GetMapping("/list")
    public String adminProductListV2(Model model) throws Exception {
        logger.info("item list");
        List<ProductVO> itemList = adminService.productList();
        logger.info("list={}", itemList);
        model.addAttribute("list", itemList);

        return "/admin/list";
    }

    // 상품 수정
    @GetMapping("/modify/{productIndex}")
    public String getProductModify(
            @PathVariable("productIndex") Integer productIndex,
            Model model) throws Exception {
        logger.info("수정 페이지로 이동");

        ProductVO product = adminService.productView(productIndex);
        logger.info("product={}", product);

        model.addAttribute("product", product);


        List<ProductCategoryVO> category = null;

        category = adminService.category();
        model.addAttribute("category", JSONArray.fromObject(category));

        return "admin/modify";
    }


    // 상품 수정 요청시 redirect를 사용해서 상품 상세페이지로 이동
    @PostMapping("/modify/{productIndex}")
    public String postProductModify(@PathVariable("productIndex")Integer productIndex,
                                    ProductVO product,
                                    HttpServletRequest request) throws Exception {
        logger.info("상품 수정 요청 상품 정보={}", product);
        logger.info("productIndex={}", productIndex);

        adminService.productModify(product);
        return "redirect:/ProductPage/{productIndex}";
    }

    // 상품 삭제
    @PostMapping("/delete/{productIndex}")
    public String deleteProduct(@PathVariable("productIndex")int productIndex) throws Exception {
        adminService.productDelete(productIndex);
        return "redirect:/admin/list";
    }

    // 관리자용 주문 현황 목록(주문 리스트)
    @GetMapping("/orderList")
    public String adminOrderList(HttpServletRequest request,
                                 Model model) {
        logger.info("주문 리스트 페이지");
        // 세션을 가져와서 userIndex 오더리스트를 출력 (userIndex == 1)일때 모든 리스트출력
        UserVO loginUser = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
        List<OrderVO> orderList = orderService.orderList(loginUser.getUserIndex());
        // orderStateList를 가져와 모델에 넣어서 전송 (배송정보를 바꾸기 위함)
        List<OrderVO> orderStateList = orderService.orderStateList();
        logger.info("orderList={}", orderList);
        logger.info("////////////////////////// orderStateList={}", orderStateList);
        model.addAttribute("orderList", orderList);
        logger.info("orderList={}", model.getAttribute("orderList"));
        model.addAttribute("orderStateList", JSONArray.fromObject(orderStateList));
        logger.info("orderStateList={}", model.getAttribute("orderStateList"));


        return "user/orderList";
    }

    @GetMapping("/userList")
    public String userList(Model model){
        logger.info("유저 리스트 출력");
        List<UserVO> userAllList = userService.findAllUser();
        logger.info("userAllList={}", userAllList);

        model.addAttribute("userAllList", userAllList);

        return "admin/userList";
    }

}