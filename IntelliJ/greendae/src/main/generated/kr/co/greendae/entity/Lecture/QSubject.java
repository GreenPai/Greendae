package kr.co.greendae.entity.Lecture;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubject is a Querydsl query type for Subject
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubject extends EntityPathBase<Subject> {

    private static final long serialVersionUID = 1451531071L;

    public static final QSubject subject = new QSubject("subject");

    public final StringPath code = createString("code");

    public final NumberPath<Integer> credits = createNumber("credits", Integer.class);

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath title = createString("title");

    public final EnumPath<SubjectType> type = createEnum("type", SubjectType.class);

    public QSubject(String variable) {
        super(Subject.class, forVariable(variable));
    }

    public QSubject(Path<? extends Subject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubject(PathMetadata metadata) {
        super(Subject.class, metadata);
    }

}

