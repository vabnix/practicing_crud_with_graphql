# GraphQL

Spring Boot 3 brought significant changes to GraphQL implementation


### Resolver Class Migration:

- Replace ``GraphQLQueryResolver`` implementations with controller classes using `@QueryMapping`
- Replace ``GraphQLMutationResolver`` implementations with controller classes using `@MutationMapping`
- Replace ``GraphQLResolver<T>`` with controller classes using `@SchemaMapping(typeName = "TypeName")`

### Schema Location:

Ensure your schema file is in `src/main/resources/graphql/schema.graphqls`
Spring Boot 3 follows convention-over-configuration for schema location

### Error Handling
Custom `DataFetcherExceptionResolver` implementations need to be adjusted

### Update Java EE imports to Jakarta EE:

- javax.persistence.* → `jakarta.persistence.*`
- javax.validation.* → `jakarta.validation.*`