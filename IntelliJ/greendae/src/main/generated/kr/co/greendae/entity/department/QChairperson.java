package kr.co.greendae.entity.department;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChairperson is a Querydsl query type for Chairperson
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChairperson extends EntityPathBase<Chairperson> {

    private static final long serialVersionUID = -201131653L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChairperson chairperson = new QChairperson("chairperson");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final kr.co.greendae.entity.user.QProfessor professor;

    public QChairperson(String variable) {
        this(Chairperson.class, forVariable(variable), INITS);
    }

    public QChairperson(Path<? extends Chairperson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChairperson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChairperson(PathMetadata metadata, PathInits inits) {
        this(Chairperson.class, metadata, inits);
    }

    public QChairperson(Class<? extends Chairperson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.professor = inits.isInitialized("professor") ? new kr.co.greendae.entity.user.QProfessor(forProperty("professor"), inits.get("professor")) : null;
    }

}

