package io.study.sideproject.domain.account.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountRepositoryCustomImpl implements AccountRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

}
