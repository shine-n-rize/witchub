package witchub.com.services;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    public  void uploadFile(MultipartFile file, String username);
    public String getUploadLocation(MultipartFile file,String username);
}
