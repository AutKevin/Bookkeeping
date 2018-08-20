package com.autumn.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysRoleModuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleModuleExample() {
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

        public Criteria andRmidIsNull() {
            addCriterion("rmId is null");
            return (Criteria) this;
        }

        public Criteria andRmidIsNotNull() {
            addCriterion("rmId is not null");
            return (Criteria) this;
        }

        public Criteria andRmidEqualTo(String value) {
            addCriterion("rmId =", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotEqualTo(String value) {
            addCriterion("rmId <>", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThan(String value) {
            addCriterion("rmId >", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThanOrEqualTo(String value) {
            addCriterion("rmId >=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThan(String value) {
            addCriterion("rmId <", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThanOrEqualTo(String value) {
            addCriterion("rmId <=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLike(String value) {
            addCriterion("rmId like", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotLike(String value) {
            addCriterion("rmId not like", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidIn(List<String> values) {
            addCriterion("rmId in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotIn(List<String> values) {
            addCriterion("rmId not in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidBetween(String value1, String value2) {
            addCriterion("rmId between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotBetween(String value1, String value2) {
            addCriterion("rmId not between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andRolecodeIsNull() {
            addCriterion("roleCode is null");
            return (Criteria) this;
        }

        public Criteria andRolecodeIsNotNull() {
            addCriterion("roleCode is not null");
            return (Criteria) this;
        }

        public Criteria andRolecodeEqualTo(String value) {
            addCriterion("roleCode =", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeNotEqualTo(String value) {
            addCriterion("roleCode <>", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeGreaterThan(String value) {
            addCriterion("roleCode >", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeGreaterThanOrEqualTo(String value) {
            addCriterion("roleCode >=", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeLessThan(String value) {
            addCriterion("roleCode <", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeLessThanOrEqualTo(String value) {
            addCriterion("roleCode <=", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeLike(String value) {
            addCriterion("roleCode like", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeNotLike(String value) {
            addCriterion("roleCode not like", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeIn(List<String> values) {
            addCriterion("roleCode in", values, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeNotIn(List<String> values) {
            addCriterion("roleCode not in", values, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeBetween(String value1, String value2) {
            addCriterion("roleCode between", value1, value2, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeNotBetween(String value1, String value2) {
            addCriterion("roleCode not between", value1, value2, "rolecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeIsNull() {
            addCriterion("moduleCode is null");
            return (Criteria) this;
        }

        public Criteria andModulecodeIsNotNull() {
            addCriterion("moduleCode is not null");
            return (Criteria) this;
        }

        public Criteria andModulecodeEqualTo(String value) {
            addCriterion("moduleCode =", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeNotEqualTo(String value) {
            addCriterion("moduleCode <>", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeGreaterThan(String value) {
            addCriterion("moduleCode >", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeGreaterThanOrEqualTo(String value) {
            addCriterion("moduleCode >=", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeLessThan(String value) {
            addCriterion("moduleCode <", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeLessThanOrEqualTo(String value) {
            addCriterion("moduleCode <=", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeLike(String value) {
            addCriterion("moduleCode like", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeNotLike(String value) {
            addCriterion("moduleCode not like", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeIn(List<String> values) {
            addCriterion("moduleCode in", values, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeNotIn(List<String> values) {
            addCriterion("moduleCode not in", values, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeBetween(String value1, String value2) {
            addCriterion("moduleCode between", value1, value2, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeNotBetween(String value1, String value2) {
            addCriterion("moduleCode not between", value1, value2, "modulecode");
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