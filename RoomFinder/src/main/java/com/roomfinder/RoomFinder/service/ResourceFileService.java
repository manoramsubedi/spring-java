package com.roomfinder.RoomFinder.service;

import com.roomfinder.RoomFinder.model.ResourceFile;
import com.roomfinder.RoomFinder.utils.FileType;
import org.springframework.web.multipart.MultipartFile;

public interface ResourceFileService {
    ResourceFile addFile(MultipartFile multipartFile, FileType fileType);

    ResourceFile findById(int id);
}
