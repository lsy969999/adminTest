package com.example.admin.samplemvc.repository.sample;

import com.example.admin.samplemvc.entity.QSampleEntity;
import com.example.admin.samplemvc.entity.SampleEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SampleRepositoryCustomImpl implements SampleRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<SampleEntity> getAll() {
        QSampleEntity qse = QSampleEntity.sampleEntity;
        List<SampleEntity> sampleEntities = queryFactory.select(qse).from(qse).fetch();
        return sampleEntities;
    }
}
