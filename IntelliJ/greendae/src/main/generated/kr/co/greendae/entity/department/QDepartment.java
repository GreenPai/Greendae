package kr.co.greendae.entity.department;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDepartment is a Querydsl query type for Department
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartment extends EntityPathBase<Department> {

    private static final long serialVersionUID = -1088754671L;

    public static final QDepartment department = new QDepartment("department");

    public final StringPath college = createString("college");

    public final StringPath deptEname = createString("deptEname");

    public final StringPath deptHp = createString("deptHp");

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptNo = createNumber("deptNo", Integer.class);

    public final StringPath deptOffice = createString("deptOffice");

    public final StringPath establishedYear = createString("establishedYear");

    public final NumberPath<Integer> totalLecturers = createNumber("totalLecturers", Integer.class);

    public final NumberPath<Integer> totalProfessors = createNumber("totalProfessors", Integer.class);

    public final NumberPath<Integer> totalStudents = createNumber("totalStudents", Integer.class);

    public QDepartment(String variable) {
        super(Department.class, forVariable(variable));
    }

    public QDepartment(Path<? extends Department> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartment(PathMetadata metadata) {
        super(Department.class, metadata);
    }

}

