package io.study.sideproject.domain.goods.model;

import io.study.sideproject.domain.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "files")
@Entity
public class File extends BaseEntity {

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
    private String filePath;

    @Column(nullable = false)
    private Boolean representative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Builder

    public File(Long id, Long size, String extension, String originalName,
                String filePath, Boolean representative, Goods goods) {
        this.id = id;
        this.size = size;
        this.extension = extension;
        this.originalName = originalName;
        this.filePath = filePath;
        this.representative = representative;
        this.goods = goods;
    }
}
