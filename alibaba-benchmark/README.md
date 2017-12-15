# AliBaba Benchmark

[AliBaba](https://bitbucket.org/openrdf/alibaba/)

Latest commit in repository: May 25, 2016

Not present in Maven central, need to clone sources and install into local repository.

Requires **Sesame 2.8.8**.

### Notes

Had to create local interfaces in the model. When the classes directly inherited form the core interfaces, 
lazy loading did not work and the benchmark was failing with NPX.

Have to explicitly register entity classes.