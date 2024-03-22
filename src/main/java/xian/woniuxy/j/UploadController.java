package xian.woniuxy.j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.crypto.spec.PSource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class UploadController {

    @RequestMapping("upload.do")
    @ResponseBody
    public String upload(MultipartFile photo, HttpServletRequest request) throws IOException {  // code review

        // 获取新的文件名
        String newFileName = getNewFileName(photo);
        // 获取上传目录
        File uploadDir = getUploadDir(request);
        // 将文件保存到磁盘
        saveToDisk(photo, newFileName, uploadDir);

        return "j";
    }


    @RequestMapping("upload2.do")
    @ResponseBody
    public String upload2(User user, MultipartFile[] photos, HttpServletRequest request) throws IOException {  // code review

        System.out.println("user = " + user);

        // 遍历文件数组
        for (MultipartFile photo : photos) {
            // 获取新的文件名
            String newFileName = getNewFileName(photo);
            // 获取上传目录
            File uploadDir = getUploadDir(request);
            // 将文件保存到磁盘
            saveToDisk(photo, newFileName, uploadDir);
        }

        return "j";
    }

    private static void saveToDisk(MultipartFile photo, String newFileName, File uploadDir) throws IOException {
        // 将文件保存到指定目录
        photo.transferTo(new File(uploadDir, newFileName));
    }

    private static File getUploadDir(HttpServletRequest request) {
        // 得到的是，运行时，当前应用所在的目录
        String realPath = request.getServletContext().getRealPath("/");

        System.out.println("realPath = " + realPath);

        File uploadDir = new File(realPath + "\\images");
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        return uploadDir;
    }

    private static String getNewFileName(MultipartFile photo) {
        // 获取原始文件名
        String originalFilename = photo.getOriginalFilename();
        // 获取文件后缀
        String ext = getFileExt(originalFilename);
        // 生成新的文件名
        String newFileName = UUID.randomUUID().toString() + ext;
        return newFileName;
    }

    private static String getFileExt(String originalFilename) {
//        Pattern p = Pattern.compile(".*(\\..+)");   //  123456.jpg
//        Matcher matcher = p.matcher(originalFilename);
//        String ext = null;
//        if (matcher.find()) {
//            ext = matcher.group(1);
//        }
//        return ext;

        // 获取原来的后缀
        int lastDotIndex = originalFilename.lastIndexOf('.');
        String ext = originalFilename.substring(lastDotIndex);
        return ext;
    }
}