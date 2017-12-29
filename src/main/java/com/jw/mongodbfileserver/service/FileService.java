package com.jw.mongodbfileserver.service;


import com.jw.mongodbfileserver.domain.File;

import java.util.List;

public interface FileService {
    /**
     * save the file.
     * @param file
     * @return
     */
    File saveFile(File file);

    /**
     * delete the file by id.
     * @param id
     */
    void removeFile(String id);

    /**
     * return the file by id.
     * @param id
     * @return
     */
    File getFileById(String id);

    /**
     * paginated result of files , based on the descending order of the uploadDate (uploading time).
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<File> listFilesByPages(int pageIndex, int pageSize);
}
