package kr.co.greendae.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProfessor is a Querydsl query type for Professor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProfessor extends EntityPathBase<Professor> {

    private static final long serialVersionUID = -156067639L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfessor professor = new QProfessor("professor");

    public final StringPath appointmentDate = createString("appointmentDate");

    public final StringPath degree = createString("degree");

    public final kr.co.greendae.entity.department.QDepartment department;

    public final StringPath graduationDate = createString("graduationDate");

    public final StringPath graduationSchool = createString("graduationSchool");

    public final EnumPath<Position> position = createEnum("position", Position.class);

    public final StringPath proNo = createString("proNo");

    public final StringPath status = createString("status");

    public final QUser user;

    public QProfessor(String variable) {
        this(Professor.class, forVariable(variable), INITS);
    }

    public QProfessor(Path<? extends Professor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfessor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfessor(PathMetadata metadata, PathInits inits) {
        this(Professor.class, metadata, inits);
    }

    public QProfessor(Class<? extends Professor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new kr.co.greendae.entity.department.QDepartment(forProperty("department")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

