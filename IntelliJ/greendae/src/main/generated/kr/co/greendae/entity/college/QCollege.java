package kr.co.greendae.entity.college;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCollege is a Querydsl query type for College
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCollege extends EntityPathBase<College> {

    private static final long serialVersionUID = 997006051L;

    public static final QCollege college = new QCollege("college");

    public final StringPath content = createString("content");

    public final ListPath<kr.co.greendae.entity.department.Department, kr.co.greendae.entity.department.QDepartment> departments = this.<kr.co.greendae.entity.department.Department, kr.co.greendae.entity.department.QDepartment>createList("departments", kr.co.greendae.entity.department.Department.class, kr.co.greendae.entity.department.QDepartment.class, PathInits.DIRECT2);

    public final StringPath engName = createString("engName");

    public final StringPath name = createString("name");

    public final StringPath oName = createString("oName");

    public final StringPath sName = createString("sName");

    public final StringPath title = createString("title");

    public QCollege(String variable) {
        super(College.class, forVariable(variable));
    }

    public QCollege(Path<? extends College> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCollege(PathMetadata metadata) {
        super(College.class, metadata);
    }

}

