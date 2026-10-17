package kr.co.greendae.entity.community.article;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBasicArticle is a Querydsl query type for BasicArticle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBasicArticle extends EntityPathBase<BasicArticle> {

    private static final long serialVersionUID = 1985889986L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBasicArticle basicArticle = new QBasicArticle("basicArticle");

    public final ListPath<kr.co.greendae.entity.community.file.BasicFile, kr.co.greendae.entity.community.file.QBasicFile> basicFiles = this.<kr.co.greendae.entity.community.file.BasicFile, kr.co.greendae.entity.community.file.QBasicFile>createList("basicFiles", kr.co.greendae.entity.community.file.BasicFile.class, kr.co.greendae.entity.community.file.QBasicFile.class, PathInits.DIRECT2);

    public final StringPath cate = createString("cate");

    public final NumberPath<Integer> comment = createNumber("comment", Integer.class);

    public final StringPath content = createString("content");

    public final StringPath edate = createString("edate");

    public final NumberPath<Integer> file = createNumber("file", Integer.class);

    public final NumberPath<Integer> hit = createNumber("hit", Integer.class);

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath regip = createString("regip");

    public final StringPath title = createString("title");

    public final kr.co.greendae.entity.user.QUser user;

    public final DateTimePath<java.time.LocalDateTime> wdate = createDateTime("wdate", java.time.LocalDateTime.class);

    public QBasicArticle(String variable) {
        this(BasicArticle.class, forVariable(variable), INITS);
    }

    public QBasicArticle(Path<? extends BasicArticle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBasicArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBasicArticle(PathMetadata metadata, PathInits inits) {
        this(BasicArticle.class, metadata, inits);
    }

    public QBasicArticle(Class<? extends BasicArticle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new kr.co.greendae.entity.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

