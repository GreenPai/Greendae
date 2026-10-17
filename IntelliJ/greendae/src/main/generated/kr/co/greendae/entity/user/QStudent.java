package kr.co.greendae.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 1777603349L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudent student = new QStudent("student");

    public final StringPath admission_type = createString("admission_type");

    public final StringPath admission_year = createString("admission_year");

    public final kr.co.greendae.entity.department.QDepartment department;

    public final StringPath graduation_year = createString("graduation_year");

    public final QProfessor professor;

    public final NumberPath<Integer> registerCredits = createNumber("registerCredits", Integer.class);

    public final StringPath stdClass = createString("stdClass");

    public final StringPath stdNo = createString("stdNo");

    public final StringPath stdSemester = createString("stdSemester");

    public final StringPath stdStatus = createString("stdStatus");

    public final NumberPath<Integer> stdYear = createNumber("stdYear", Integer.class);

    public final QUser user;

    public QStudent(String variable) {
        this(Student.class, forVariable(variable), INITS);
    }

    public QStudent(Path<? extends Student> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudent(PathMetadata metadata, PathInits inits) {
        this(Student.class, metadata, inits);
    }

    public QStudent(Class<? extends Student> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new kr.co.greendae.entity.department.QDepartment(forProperty("department")) : null;
        this.professor = inits.isInitialized("professor") ? new QProfessor(forProperty("professor"), inits.get("professor")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

