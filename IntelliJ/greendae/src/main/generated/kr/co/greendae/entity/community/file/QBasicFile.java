package kr.co.greendae.entity.community.file;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicFile is a Querydsl query type for BasicFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBasicFile extends EntityPathBase<BasicFile> {

    private static final long serialVersionUID = 2133910010L;

    public static final QBasicFile basicFile = new QBasicFile("basicFile");

    public final NumberPath<Integer> ano = createNumber("ano", Integer.class);

    public final NumberPath<Integer> download = createNumber("download", Integer.class);

    public final NumberPath<Integer> fno = createNumber("fno", Integer.class);

    public final StringPath oName = createString("oName");

    public final DateTimePath<java.time.LocalDateTime> rdate = createDateTime("rdate", java.time.LocalDateTime.class);

    public final StringPath sName = createString("sName");

    public QBasicFile(String variable) {
        super(BasicFile.class, forVariable(variable));
    }

    public QBasicFile(Path<? extends BasicFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicFile(PathMetadata metadata) {
        super(BasicFile.class, metadata);
    }

}

