package com.autumn.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysModuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysModuleExample() {
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

        public Criteria andmoduleCodeIsNull() {
            addCriterion("moduleCode is null");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeIsNotNull() {
            addCriterion("moduleCode is not null");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeEqualTo(String value) {
            addCriterion("moduleCode =", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeNotEqualTo(String value) {
            addCriterion("moduleCode <>", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeGreaterThan(String value) {
            addCriterion("moduleCode >", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("moduleCode >=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeLessThan(String value) {
            addCriterion("moduleCode <", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeLessThanOrEqualTo(String value) {
            addCriterion("moduleCode <=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeLike(String value) {
            addCriterion("moduleCode like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeNotLike(String value) {
            addCriterion("moduleCode not like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeIn(List<String> values) {
            addCriterion("moduleCode in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeNotIn(List<String> values) {
            addCriterion("moduleCode not in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeBetween(String value1, String value2) {
            addCriterion("moduleCode between", value1, value2, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andmoduleCodeNotBetween(String value1, String value2) {
            addCriterion("moduleCode not between", value1, value2, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModulenameIsNull() {
            addCriterion("moduleName is null");
            return (Criteria) this;
        }

        public Criteria andModulenameIsNotNull() {
            addCriterion("moduleName is not null");
            return (Criteria) this;
        }

        public Criteria andModulenameEqualTo(String value) {
            addCriterion("moduleName =", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotEqualTo(String value) {
            addCriterion("moduleName <>", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameGreaterThan(String value) {
            addCriterion("moduleName >", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameGreaterThanOrEqualTo(String value) {
            addCriterion("moduleName >=", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameLessThan(String value) {
            addCriterion("moduleName <", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameLessThanOrEqualTo(String value) {
            addCriterion("moduleName <=", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameLike(String value) {
            addCriterion("moduleName like", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotLike(String value) {
            addCriterion("moduleName not like", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameIn(List<String> values) {
            addCriterion("moduleName in", values, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotIn(List<String> values) {
            addCriterion("moduleName not in", values, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameBetween(String value1, String value2) {
            addCriterion("moduleName between", value1, value2, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotBetween(String value1, String value2) {
            addCriterion("moduleName not between", value1, value2, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulepathIsNull() {
            addCriterion("modulePath is null");
            return (Criteria) this;
        }

        public Criteria andModulepathIsNotNull() {
            addCriterion("modulePath is not null");
            return (Criteria) this;
        }

        public Criteria andModulepathEqualTo(String value) {
            addCriterion("modulePath =", value, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathNotEqualTo(String value) {
            addCriterion("modulePath <>", value, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathGreaterThan(String value) {
            addCriterion("modulePath >", value, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathGreaterThanOrEqualTo(String value) {
            addCriterion("modulePath >=", value, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathLessThan(String value) {
            addCriterion("modulePath <", value, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathLessThanOrEqualTo(String value) {
            addCriterion("modulePath <=", value, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathLike(String value) {
            addCriterion("modulePath like", value, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathNotLike(String value) {
            addCriterion("modulePath not like", value, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathIn(List<String> values) {
            addCriterion("modulePath in", values, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathNotIn(List<String> values) {
            addCriterion("modulePath not in", values, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathBetween(String value1, String value2) {
            addCriterion("modulePath between", value1, value2, "modulepath");
            return (Criteria) this;
        }

        public Criteria andModulepathNotBetween(String value1, String value2) {
            addCriterion("modulePath not between", value1, value2, "modulepath");
            return (Criteria) this;
        }

        public Criteria andParentcodeIsNull() {
            addCriterion("parentCode is null");
            return (Criteria) this;
        }

        public Criteria andParentcodeIsNotNull() {
            addCriterion("parentCode is not null");
            return (Criteria) this;
        }

        public Criteria andParentcodeEqualTo(String value) {
            addCriterion("parentCode =", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotEqualTo(String value) {
            addCriterion("parentCode <>", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThan(String value) {
            addCriterion("parentCode >", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("parentCode >=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThan(String value) {
            addCriterion("parentCode <", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThanOrEqualTo(String value) {
            addCriterion("parentCode <=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLike(String value) {
            addCriterion("parentCode like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotLike(String value) {
            addCriterion("parentCode not like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeIn(List<String> values) {
            addCriterion("parentCode in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotIn(List<String> values) {
            addCriterion("parentCode not in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeBetween(String value1, String value2) {
            addCriterion("parentCode between", value1, value2, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotBetween(String value1, String value2) {
            addCriterion("parentCode not between", value1, value2, "parentcode");
            return (Criteria) this;
        }

        public Criteria andIsleafIsNull() {
            addCriterion("isLeaf is null");
            return (Criteria) this;
        }

        public Criteria andIsleafIsNotNull() {
            addCriterion("isLeaf is not null");
            return (Criteria) this;
        }

        public Criteria andIsleafEqualTo(Integer value) {
            addCriterion("isLeaf =", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotEqualTo(Integer value) {
            addCriterion("isLeaf <>", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafGreaterThan(Integer value) {
            addCriterion("isLeaf >", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafGreaterThanOrEqualTo(Integer value) {
            addCriterion("isLeaf >=", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafLessThan(Integer value) {
            addCriterion("isLeaf <", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafLessThanOrEqualTo(Integer value) {
            addCriterion("isLeaf <=", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafIn(List<Integer> values) {
            addCriterion("isLeaf in", values, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotIn(List<Integer> values) {
            addCriterion("isLeaf not in", values, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafBetween(Integer value1, Integer value2) {
            addCriterion("isLeaf between", value1, value2, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotBetween(Integer value1, Integer value2) {
            addCriterion("isLeaf not between", value1, value2, "isleaf");
            return (Criteria) this;
        }

        public Criteria andSortnumberIsNull() {
            addCriterion("sortNumber is null");
            return (Criteria) this;
        }

        public Criteria andSortnumberIsNotNull() {
            addCriterion("sortNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSortnumberEqualTo(Integer value) {
            addCriterion("sortNumber =", value, "sortnumber");
            return (Criteria) this;
        }

        public Criteria andSortnumberNotEqualTo(Integer value) {
            addCriterion("sortNumber <>", value, "sortnumber");
            return (Criteria) this;
        }

        public Criteria andSortnumberGreaterThan(Integer value) {
            addCriterion("sortNumber >", value, "sortnumber");
            return (Criteria) this;
        }

        public Criteria andSortnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sortNumber >=", value, "sortnumber");
            return (Criteria) this;
        }

        public Criteria andSortnumberLessThan(Integer value) {
            addCriterion("sortNumber <", value, "sortnumber");
            return (Criteria) this;
        }

        public Criteria andSortnumberLessThanOrEqualTo(Integer value) {
            addCriterion("sortNumber <=", value, "sortnumber");
            return (Criteria) this;
        }

        public Criteria andSortnumberIn(List<Integer> values) {
            addCriterion("sortNumber in", values, "sortnumber");
            return (Criteria) this;
        }

        public Criteria andSortnumberNotIn(List<Integer> values) {
            addCriterion("sortNumber not in", values, "sortnumber");
            return (Criteria) this;
        }

        public Criteria andSortnumberBetween(Integer value1, Integer value2) {
            addCriterion("sortNumber between", value1, value2, "sortnumber");
            return (Criteria) this;
        }

        public Criteria andSortnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sortNumber not between", value1, value2, "sortnumber");
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