# AliBaba Benchmark

[AliBaba](https://bitbucket.org/openrdf/alibaba/)

Latest commit in repository: May 25, 2016

Not present in Maven central, need to clone sources and install into local repository.

Requires **Sesame 2.8.8**.

### Notes

* Had to create local interfaces in the model. When the classes directly inherited form the core interfaces, 
lazy loading did not work and the benchmark was failing with NPX.
* Have to explicitly register entity classes.
* Does not support detached objects, so cannot use merge in the update benchmark. Instead, an object must be read and changes applied to this
managed instance. Reference the JOINT-DE article.
* Entity class must be annotated with @Iri, otherwise `getObject` does not work.
* Entity class cannot store instance identifier (URI). It is not populated when calling `getObject`.
* Must call getters to trigger value loading in proxies.
* For some reason, equals of instances is not utilized when they are in collections. So
two collections of entities (`Resource`), where one is manually created
and the other is read from the repository, are not equal, although they contain the same elements.
