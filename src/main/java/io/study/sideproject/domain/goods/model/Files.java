package io.study.sideproject.domain.goods.model;

import io.study.sideproject.domain.common.BaseEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "files")
@Entity
public class Files extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String storeName;

    @Setter
    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private Boolean representative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Builder
    public Files(Long id, MultipartFile image, String filePath, Boolean representative, Goods goods) {
        this.id = id;
        setFile(image);
        this.filePath = filePath;
        this.representative = representative;
        this.goods = goods;
    }

    private void setFile(MultipartFile image) {
        this.size = image.getSize();
        this.originalName = image.getOriginalFilename();
        this.extension = extractExt();
        this.storeName = createStoreFileName();
    }

    private String extractExt() {
        int pos = originalName.lastIndexOf(".");
        return originalName.substring(pos + 1);
    }

    private String createStoreFileName() {
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + extension;
    }

}
