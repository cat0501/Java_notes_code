package com.itheima.shiro.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer page;

    private Integer row;

    private String resultColumn;

    public CompanyExample() {
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

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getStartRowNum() {
        return (this.page != null && this.row != null) ? ((this.page - 1) * this.row) : null;
    }

    public String getResultColumn() {
        return this.resultColumn;
    }

    public void setResultColumn(String resultColumn) {
        this.resultColumn = resultColumn;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tp_company
     *
     * @mbg.generated Mon Feb 24 16:00:37 CST 2020
     */
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value + "%", "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value + "%", "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEnableFlagIsNull() {
            addCriterion("ENABLE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEnableFlagIsNotNull() {
            addCriterion("ENABLE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEnableFlagEqualTo(String value) {
            addCriterion("ENABLE_FLAG =", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotEqualTo(String value) {
            addCriterion("ENABLE_FLAG <>", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagGreaterThan(String value) {
            addCriterion("ENABLE_FLAG >", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ENABLE_FLAG >=", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagLessThan(String value) {
            addCriterion("ENABLE_FLAG <", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagLessThanOrEqualTo(String value) {
            addCriterion("ENABLE_FLAG <=", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagLike(String value) {
            addCriterion("ENABLE_FLAG like", value + "%", "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotLike(String value) {
            addCriterion("ENABLE_FLAG not like", value + "%", "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagIn(List<String> values) {
            addCriterion("ENABLE_FLAG in", values, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotIn(List<String> values) {
            addCriterion("ENABLE_FLAG not in", values, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagBetween(String value1, String value2) {
            addCriterion("ENABLE_FLAG between", value1, value2, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotBetween(String value1, String value2) {
            addCriterion("ENABLE_FLAG not between", value1, value2, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value + "%", "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value + "%", "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value + "%", "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value + "%", "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCompanyNoIsNull() {
            addCriterion("company_no is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNoIsNotNull() {
            addCriterion("company_no is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNoEqualTo(String value) {
            addCriterion("company_no =", value, "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoNotEqualTo(String value) {
            addCriterion("company_no <>", value, "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoGreaterThan(String value) {
            addCriterion("company_no >", value, "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoGreaterThanOrEqualTo(String value) {
            addCriterion("company_no >=", value, "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoLessThan(String value) {
            addCriterion("company_no <", value, "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoLessThanOrEqualTo(String value) {
            addCriterion("company_no <=", value, "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoLike(String value) {
            addCriterion("company_no like", value + "%", "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoNotLike(String value) {
            addCriterion("company_no not like", value + "%", "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoIn(List<String> values) {
            addCriterion("company_no in", values, "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoNotIn(List<String> values) {
            addCriterion("company_no not in", values, "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoBetween(String value1, String value2) {
            addCriterion("company_no between", value1, value2, "companyNo");
            return (Criteria) this;
        }

        public Criteria andCompanyNoNotBetween(String value1, String value2) {
            addCriterion("company_no not between", value1, value2, "companyNo");
            return (Criteria) this;
        }

        public Criteria andBossIsNull() {
            addCriterion("boss is null");
            return (Criteria) this;
        }

        public Criteria andBossIsNotNull() {
            addCriterion("boss is not null");
            return (Criteria) this;
        }

        public Criteria andBossEqualTo(String value) {
            addCriterion("boss =", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossNotEqualTo(String value) {
            addCriterion("boss <>", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossGreaterThan(String value) {
            addCriterion("boss >", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossGreaterThanOrEqualTo(String value) {
            addCriterion("boss >=", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossLessThan(String value) {
            addCriterion("boss <", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossLessThanOrEqualTo(String value) {
            addCriterion("boss <=", value, "boss");
            return (Criteria) this;
        }

        public Criteria andBossLike(String value) {
            addCriterion("boss like", value + "%", "boss");
            return (Criteria) this;
        }

        public Criteria andBossNotLike(String value) {
            addCriterion("boss not like", value + "%", "boss");
            return (Criteria) this;
        }

        public Criteria andBossIn(List<String> values) {
            addCriterion("boss in", values, "boss");
            return (Criteria) this;
        }

        public Criteria andBossNotIn(List<String> values) {
            addCriterion("boss not in", values, "boss");
            return (Criteria) this;
        }

        public Criteria andBossBetween(String value1, String value2) {
            addCriterion("boss between", value1, value2, "boss");
            return (Criteria) this;
        }

        public Criteria andBossNotBetween(String value1, String value2) {
            addCriterion("boss not between", value1, value2, "boss");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundIsNull() {
            addCriterion("registered_fund is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundIsNotNull() {
            addCriterion("registered_fund is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundEqualTo(String value) {
            addCriterion("registered_fund =", value, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundNotEqualTo(String value) {
            addCriterion("registered_fund <>", value, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundGreaterThan(String value) {
            addCriterion("registered_fund >", value, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundGreaterThanOrEqualTo(String value) {
            addCriterion("registered_fund >=", value, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundLessThan(String value) {
            addCriterion("registered_fund <", value, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundLessThanOrEqualTo(String value) {
            addCriterion("registered_fund <=", value, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundLike(String value) {
            addCriterion("registered_fund like", value + "%", "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundNotLike(String value) {
            addCriterion("registered_fund not like", value + "%", "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundIn(List<String> values) {
            addCriterion("registered_fund in", values, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundNotIn(List<String> values) {
            addCriterion("registered_fund not in", values, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundBetween(String value1, String value2) {
            addCriterion("registered_fund between", value1, value2, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredFundNotBetween(String value1, String value2) {
            addCriterion("registered_fund not between", value1, value2, "registeredFund");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeIsNull() {
            addCriterion("registered_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeIsNotNull() {
            addCriterion("registered_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeEqualTo(Date value) {
            addCriterion("registered_time =", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeNotEqualTo(Date value) {
            addCriterion("registered_time <>", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeGreaterThan(Date value) {
            addCriterion("registered_time >", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("registered_time >=", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeLessThan(Date value) {
            addCriterion("registered_time <", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeLessThanOrEqualTo(Date value) {
            addCriterion("registered_time <=", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeIn(List<Date> values) {
            addCriterion("registered_time in", values, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeNotIn(List<Date> values) {
            addCriterion("registered_time not in", values, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeBetween(Date value1, Date value2) {
            addCriterion("registered_time between", value1, value2, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeNotBetween(Date value1, Date value2) {
            addCriterion("registered_time not between", value1, value2, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberIsNull() {
            addCriterion("insurance_number is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberIsNotNull() {
            addCriterion("insurance_number is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberEqualTo(Integer value) {
            addCriterion("insurance_number =", value, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberNotEqualTo(Integer value) {
            addCriterion("insurance_number <>", value, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberGreaterThan(Integer value) {
            addCriterion("insurance_number >", value, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("insurance_number >=", value, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberLessThan(Integer value) {
            addCriterion("insurance_number <", value, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberLessThanOrEqualTo(Integer value) {
            addCriterion("insurance_number <=", value, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberIn(List<Integer> values) {
            addCriterion("insurance_number in", values, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberNotIn(List<Integer> values) {
            addCriterion("insurance_number not in", values, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberBetween(Integer value1, Integer value2) {
            addCriterion("insurance_number between", value1, value2, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andInsuranceNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("insurance_number not between", value1, value2, "insuranceNumber");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value + "%", "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value + "%", "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tp_company
     *
     * @mbg.generated do_not_delete_during_merge Mon Feb 24 16:00:37 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tp_company
     *
     * @mbg.generated Mon Feb 24 16:00:37 CST 2020
     */
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