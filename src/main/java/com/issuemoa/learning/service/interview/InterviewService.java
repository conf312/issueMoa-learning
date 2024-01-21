package com.issuemoa.learning.service.interview;

import com.issuemoa.learning.common.UsersRestApi;
import com.issuemoa.learning.domain.interview.QInterview;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InterviewService {
    private final UsersRestApi usersRestApi;
    private final JPAQueryFactory jpaQueryFactory;
    private final QInterview interview = QInterview.interview;

    public HashMap<String, Object> findAll(String category) {
        HashMap<String, Object> resultMap = new HashMap<>();

        List<interviewResponse> list = jpaQueryFactory
            .select(Projections.constructor(interviewResponse.class,
                interview.id,
                interview.category,
                interview.question,
                interview.answer
            ))
            .from(interview)
            .where(interview.category.eq(category))
            .orderBy(interview.id.asc())
            .fetch();

        resultMap.put("list", list);

        return resultMap;
    }
}
