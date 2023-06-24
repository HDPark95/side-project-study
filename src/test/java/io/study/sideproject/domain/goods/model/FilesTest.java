package io.study.sideproject.domain.goods.model;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FilesTest {

    @Test
    public void fileSettingTest() throws Exception {
        //given
        String fileName = "abcde.png";
        String ext = "png";
        byte[] file = fileName.getBytes();
        MultipartFile multipartFile = new MockMultipartFile(fileName, fileName, ext, file);

        //when
        Files files = Files.builder()
                .image(multipartFile)
                .build();

        //then
        assertThat(files.getSize()).isEqualTo(file.length);
        assertThat(files.getExtension()).isEqualTo(ext);
        assertThat(files.getStoreName()).isNotEqualTo(fileName);
        assertThat(files.getOriginalName()).isEqualTo(fileName);
    }
}