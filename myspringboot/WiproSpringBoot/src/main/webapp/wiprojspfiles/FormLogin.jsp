
<!-- THIS JSP FILE COMPLETELY DEPENDS ON FORMBEAN.JAVA -->

<!-- JSTL:: JSP Standard Tag library -->
<!-- JSTL SPRING BOOT FORM TAGS(server side) is similar to HTML FORM TAGS(client side) -->

<%@taglib prefix="wipro_form" uri="http://www.springframework.org/tags/form" %><!-- "result" is FormBean class object -->

<!-- "result" is FormBean class object -->

<!-- setters method are called and their values are set in the FormBean 
that was indicated in the 
modelAttribute="result" in the form tag. -->

<!-- valid is @RequestMapping URL pattern that will call SUCCESS JSP VIEW LAYER -->

<!-- modelAttribute present=>	✅ Binds form to model object -->

<wipro_form:form action="valid" modelAttribute="result">

<!-- SPRING BOOT textbox -->

<!-- path::: connects to pojo/Bean class SETTER property! -->
<!-- result.setName() -->
Name:: <wipro_form:input path="name"/><br>


<!-- result.setF_hobbies() -->
Hobbies::
Shopping<wipro_form:checkbox path="f_hobbies" value="Shopping"/>
Cricket<wipro_form:checkbox path="f_hobbies" value="Cricket"/>
Social Media<wipro_form:checkbox path="f_hobbies" value="Facebook,Instagram,Twitter"/>

<!-- result.setGender() -->
<br>
Gender::
<wipro_form:radiobutton path="gender" value="Male"/>Male
<wipro_form:radiobutton path="gender" value="Female"/>Female

<br>
<!-- taking the country value from controller -->
<!-- option tag is not required! -->

Country::
<wipro_form:select path="country" multiple="true" items="${countryoptions}" 
value="${countryoptions}"/>

<input type="submit" value="Submit">


</wipro_form:form>
