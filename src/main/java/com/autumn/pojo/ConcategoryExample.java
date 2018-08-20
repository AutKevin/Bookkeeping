package com.autumn.pojo;

import java.util.ArrayList;
import java.util.List;

public class ConcategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConcategoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCateCodeIsNull() {
            addCriterion("cate_code is null");
            return (Criteria) this;
        }

        public Criteria andCateCodeIsNotNull() {
            addCriterion("cate_code is not null");
            return (Criteria) this;
        }

        public Criteria andCateCodeEqualTo(String value) {
            addCriterion("cate_code =", value, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeNotEqualTo(String value) {
            addCriterion("cate_code <>", value, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeGreaterThan(String value) {
            addCriterion("cate_code >", value, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cate_code >=", value, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeLessThan(String value) {
            addCriterion("cate_code <", value, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeLessThanOrEqualTo(String value) {
            addCriterion("cate_code <=", value, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeLike(String value) {
            addCriterion("cate_code like", value, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeNotLike(String value) {
            addCriterion("cate_code not like", value, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeIn(List<String> values) {
            addCriterion("cate_code in", values, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeNotIn(List<String> values) {
            addCriterion("cate_code not in", values, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeBetween(String value1, String value2) {
            addCriterion("cate_code between", value1, value2, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateCodeNotBetween(String value1, String value2) {
            addCriterion("cate_code not between", value1, value2, "cateCode");
            return (Criteria) this;
        }

        public Criteria andCateNameIsNull() {
            addCriterion("cate_name is null");
            return (Criteria) this;
        }

        public Criteria andCateNameIsNotNull() {
            addCriterion("cate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCateNameEqualTo(String value) {
            addCriterion("cate_name =", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotEqualTo(String value) {
            addCriterion("cate_name <>", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThan(String value) {
            addCriterion("cate_name >", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThanOrEqualTo(String value) {
            addCriterion("cate_name >=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThan(String value) {
            addCriterion("cate_name <", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThanOrEqualTo(String value) {
            addCriterion("cate_name <=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLike(String value) {
            addCriterion("cate_name like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotLike(String value) {
            addCriterion("cate_name not like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameIn(List<String> values) {
            addCriterion("cate_name in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotIn(List<String> values) {
            addCriterion("cate_name not in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameBetween(String value1, String value2) {
            addCriterion("cate_name between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotBetween(String value1, String value2) {
            addCriterion("cate_name not between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateLevelIsNull() {
            addCriterion("cate_level is null");
            return (Criteria) this;
        }

        public Criteria andCateLevelIsNotNull() {
            addCriterion("cate_level is not null");
            return (Criteria) this;
        }

        public Criteria andCateLevelEqualTo(Integer value) {
            addCriterion("cate_level =", value, "cateLevel");
            return (Criteria) this;
        }

        public Criteria andCateLevelNotEqualTo(Integer value) {
            addCriterion("cate_level <>", value, "cateLevel");
            return (Criteria) this;
        }

        public Criteria andCateLevelGreaterThan(Integer value) {
            addCriterion("cate_level >", value, "cateLevel");
            return (Criteria) this;
        }

        public Criteria andCateLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("cate_level >=", value, "cateLevel");
            return (Criteria) this;
        }

        public Criteria andCateLevelLessThan(Integer value) {
            addCriterion("cate_level <", value, "cateLevel");
            return (Criteria) this;
        }

        public Criteria andCateLevelLessThanOrEqualTo(Integer value) {
            addCriterion("cate_level <=", value, "cateLevel");
            return (Criteria) this;
        }

        public Criteria andCateLevelIn(List<Integer> values) {
            addCriterion("cate_level in", values, "cateLevel");
            return (Criteria) this;
        }

        public Criteria andCateLevelNotIn(List<Integer> values) {
            addCriterion("cate_level not in", values, "cateLevel");
            return (Criteria) this;
        }

        public Criteria andCateLevelBetween(Integer value1, Integer value2) {
            addCriterion("cate_level between", value1, value2, "cateLevel");
            return (Criteria) this;
        }

        public Criteria andCateLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("cate_level not between", value1, value2, "cateLevel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}