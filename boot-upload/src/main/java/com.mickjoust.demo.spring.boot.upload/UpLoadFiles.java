package com.mickjoust.demo.spring.boot.upload;

/**
 * Author: huangjingfeng
 * Since:2019-09-15
 * 上传文件
 **/

public class UpLoadFiles {

    @PostMapping("/uploadMyFile")
    public String handleFileUpload(@RequestParam("myFile") MultipartFile file)
    {
        if (!file.isEmpty())
        {
            String name = file.getOriginalFilename();
            try
            {
                byte[] bytes = file.getBytes();
                Files.write(new File(name).toPath(), bytes);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return "redirect:/fileUpload";
    }
}
