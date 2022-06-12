package com.roomfinder.RoomFinder.controller;

import com.roomfinder.RoomFinder.model.ResourceFile;
import com.roomfinder.RoomFinder.service.ResourceFileService;
import com.roomfinder.RoomFinder.utils.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private ResourceFileService resourceFileService;

    @PostMapping
    public ResourceFile uploadFile(@RequestParam MultipartFile file, @RequestParam FileType fileType){
        return resourceFileService.addFile(file, fileType);
    }


    /*public ResourceFileService getResourceFileService() {
        return resourceFileService.
    }*/
}
