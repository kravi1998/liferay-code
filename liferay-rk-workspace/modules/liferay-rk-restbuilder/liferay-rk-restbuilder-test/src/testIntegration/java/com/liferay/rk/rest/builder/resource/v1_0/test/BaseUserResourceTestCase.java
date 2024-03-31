package com.liferay.rk.rest.builder.resource.v1_0.test;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.rk.rest.builder.client.dto.v1_0.UserObject;
import com.liferay.rk.rest.builder.client.http.HttpInvoker;
import com.liferay.rk.rest.builder.client.pagination.Page;
import com.liferay.rk.rest.builder.client.pagination.Pagination;
import com.liferay.rk.rest.builder.client.resource.v1_0.UserResource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Ravi
 * @generated
 */
@Generated("")
public abstract class BaseUserResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_userResource.setContextCompany(testCompany);

		UserResource.Builder builder = UserResource.builder();

		userResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testGetUsers() throws Exception {
		Page<User> page = userResource.getUsers(Pagination.of(1, 10));

		long totalCount = page.getTotalCount();

		User user1 = testGetUsers_addUser(randomUser());

		User user2 = testGetUsers_addUser(randomUser());

		page = userResource.getUsers(Pagination.of(1, 10));

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(user1, (List<User>)page.getItems());
		assertContains(user2, (List<User>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetUsersWithPagination() throws Exception {
		Page<User> totalPage = userResource.getUsers(null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		User user1 = testGetUsers_addUser(randomUser());

		User user2 = testGetUsers_addUser(randomUser());

		User user3 = testGetUsers_addUser(randomUser());

		Page<User> page1 = userResource.getUsers(
			Pagination.of(1, totalCount + 2));

		List<User> users1 = (List<User>)page1.getItems();

		Assert.assertEquals(users1.toString(), totalCount + 2, users1.size());

		Page<User> page2 = userResource.getUsers(
			Pagination.of(2, totalCount + 2));

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<User> users2 = (List<User>)page2.getItems();

		Assert.assertEquals(users2.toString(), 1, users2.size());

		Page<User> page3 = userResource.getUsers(
			Pagination.of(1, totalCount + 3));

		assertContains(user1, (List<User>)page3.getItems());
		assertContains(user2, (List<User>)page3.getItems());
		assertContains(user3, (List<User>)page3.getItems());
	}

	protected User testGetUsers_addUser(User user) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetUsers() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testDeleteUserById() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetUserById() throws Exception {
		User postUser = testGetUser_addUser();

		UserObject postUserObject = testGetUserById_addUserObject(
			postUser.getId(), randomUserObject());

		UserObject getUserObject = userResource.getUserById(postUser.getId());

		assertEquals(postUserObject, getUserObject);
		assertValid(getUserObject);
	}

	protected UserObject testGetUserById_addUserObject(
			long userId, UserObject userObject)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateUser() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertContains(Object user, List<Object> users) {
		boolean contains = false;

		for (Object item : users) {
			if (equals(user, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(users + " does not contain " + user, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Object user1, Object user2) {
		Assert.assertTrue(
			user1 + " does not equal " + user2, equals(user1, user2));
	}

	protected void assertEquals(List<Object> users1, List<Object> users2) {
		Assert.assertEquals(users1.size(), users2.size());

		for (int i = 0; i < users1.size(); i++) {
			Object user1 = users1.get(i);
			Object user2 = users2.get(i);

			assertEquals(user1, user2);
		}
	}

	protected void assertEquals(
		UserObject userObject1, UserObject userObject2) {

		Assert.assertTrue(
			userObject1 + " does not equal " + userObject2,
			equals(userObject1, userObject2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> users1, List<Object> users2) {

		Assert.assertEquals(users1.size(), users2.size());

		for (Object user1 : users1) {
			boolean contains = false;

			for (Object user2 : users2) {
				if (equals(user1, user2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(users2 + " does not contain " + user1, contains);
		}
	}

	protected void assertValid(Object user) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Object> page) {
		boolean valid = false;

		java.util.Collection<Object> users = page.getItems();

		int size = users.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(UserObject userObject) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalUserObjectAssertFieldNames()) {

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (userObject.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (userObject.getFirstName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (userObject.getLastName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("screenName", additionalAssertFieldName)) {
				if (userObject.getScreenName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statusCode", additionalAssertFieldName)) {
				if (userObject.getStatusCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statusMessage", additionalAssertFieldName)) {
				if (userObject.getStatusMessage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (userObject.getUserId() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalUserObjectAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Object user1, Object user2) {
		if (user1 == user2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected boolean equals(UserObject userObject1, UserObject userObject2) {
		if (userObject1 == userObject2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalUserObjectAssertFieldNames()) {

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userObject1.getEmail(), userObject2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userObject1.getFirstName(),
						userObject2.getFirstName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userObject1.getLastName(), userObject2.getLastName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("screenName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userObject1.getScreenName(),
						userObject2.getScreenName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("statusCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userObject1.getStatusCode(),
						userObject2.getStatusCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("statusMessage", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userObject1.getStatusMessage(),
						userObject2.getStatusMessage())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userObject1.getUserId(), userObject2.getUserId())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected Field[] getDeclaredFields(Class clazz) throws Exception {
		Stream<Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_userResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_userResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Object user) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected UserObject randomUserObject() throws Exception {
		return new UserObject() {
			{
				email = RandomTestUtil.randomString();
				firstName = RandomTestUtil.randomString();
				lastName = RandomTestUtil.randomString();
				screenName = RandomTestUtil.randomString();
				statusCode = RandomTestUtil.randomInteger();
				statusMessage = RandomTestUtil.randomString();
				userId = RandomTestUtil.randomLong();
			}
		};
	}

	protected UserResource userResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseUserResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.rk.rest.builder.resource.v1_0.UserResource
		_userResource;

}