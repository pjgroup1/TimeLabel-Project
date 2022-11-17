package com.javateam.TimeLabel.controller;

import com.javateam.TimeLabel.model.ProductCategoryVO;
import com.javateam.TimeLabel.model.ProductVO;
import com.javateam.TimeLabel.service.AdminService;
import com.javateam.TimeLabel.util.UploadFileUtils;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.List;


@Controller
@RequestMapping("/admin/*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;

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


    @RequestMapping(value = "ProductList", method = RequestMethod.GET)
    public String adminProductList() throws Exception {

        logger.info("#### 상품목록 페이지 이동 ####");

        return "ProductList";
    }
}