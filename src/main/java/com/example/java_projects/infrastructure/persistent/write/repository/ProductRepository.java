package com.example.java_projects.infrastructure.persistent.write.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.example.java_projects.infrastructure.persistent.write.model.Product;

@Repository
public class ProductRepository implements IProductRepository {

    private final IProductRepository jpaRepository;

    public ProductRepository(IProductRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void flush() {
        jpaRepository.flush();
    }

    @Override
    public <S extends Product> S saveAndFlush(S entity) {
        return jpaRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        return jpaRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> entities) {
        jpaRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> ids) {
        jpaRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteAllInBatch() {
        jpaRepository.deleteAllInBatch();
    }

    @Override
    public Product getOne(String id) {
        return jpaRepository.getOne(id);
    }

    @Override
    public Product getById(String id) {
        return jpaRepository.getById(id);
    }

    @Override
    public Product getReferenceById(String id) {
        return jpaRepository.getReferenceById(id);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return jpaRepository.findAll(example);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return jpaRepository.findAll(example, sort);
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public List<Product> findAllById(Iterable<String> ids) {
        return jpaRepository.findAllById(ids);
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        return jpaRepository.saveAll(entities);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }

    @Override
    public void delete(Product entity) {
        jpaRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        jpaRepository.deleteAll();
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        jpaRepository.deleteAll(entities);
    }

    @Override
    public void deleteAllById(Iterable<? extends String> ids) {
        jpaRepository.deleteAllById(ids);
    }

    @Override
    public void deleteById(String id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public Optional<Product> findById(String id) {
        return jpaRepository.findById(id);
    }

    @Override
    public <S extends Product> S save(S entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return jpaRepository.findAll(sort);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return jpaRepository.count(example);
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return jpaRepository.exists(example);
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return jpaRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return jpaRepository.findBy(example, queryFunction);
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return jpaRepository.findOne(example);
    }

    @Override
    public Optional<Product> findOne(Specification<Product> spec) {
        return jpaRepository.findOne(spec);
    }

    @Override
    public List<Product> findAll(Specification<Product> spec) {
        return jpaRepository.findAll(spec);
    }

    @Override
    public Page<Product> findAll(Specification<Product> spec, Pageable pageable) {
        return jpaRepository.findAll(spec, pageable);
    }

    @Override
    public Page<Product> findAll(Specification<Product> spec, Specification<Product> countSpec, Pageable pageable) {
        return jpaRepository.findAll(spec, countSpec, pageable);
    }

    @Override
    public List<Product> findAll(Specification<Product> spec, Sort sort) {
        return jpaRepository.findAll(spec, sort);
    }

    @Override
    public long count(Specification<Product> spec) {
        return jpaRepository.count(spec);
    }

    @Override
    public boolean exists(Specification<Product> spec) {
        return jpaRepository.exists(spec);
    }

    @Override
    public long delete(Specification<Product> spec) {
        return jpaRepository.delete(spec);
    }

    @Override
    public <S extends Product, R> R findBy(Specification<Product> spec,
            Function<? super SpecificationFluentQuery<S>, R> queryFunction) {
        return jpaRepository.findBy(spec, queryFunction);
    }

    @Override
    public List<Product> findByCategoryId(String categoryId) {
        return jpaRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Product> findByBrandId(String brandId) {
        return jpaRepository.findByBrandId(brandId);
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        return jpaRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public boolean existsBySku(String sku) {
        return jpaRepository.existsBySku(sku);
    }
}
