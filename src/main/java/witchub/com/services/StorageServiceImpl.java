package witchub.com.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageServiceImpl implements StorageService{
    public String uploadDir = "src/main/resources/static/assets/products/";

    @Override
    public String getUploadLocation(MultipartFile file, String username){
//        System.out.println("getUpload: " +uploadDir+username+"/"+ StringUtils.cleanPath(file.getOriginalFilename()));
        return "/assets/products/"+username+"/"+ StringUtils.cleanPath(file.getOriginalFilename());
    }

    @Override
    public void uploadFile(MultipartFile file, String username){
        try{
            Path copyLocation = Paths.get(uploadDir+username+"/"+ File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            if(Files.notExists(copyLocation)){
                Files.createDirectories(copyLocation);
            }
//            System.out.println("upload: "+copyLocation);
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
//            System.out.println("file: "+file);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
