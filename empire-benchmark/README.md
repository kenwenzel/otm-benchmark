# Empire Benchmark

[Empire](https://github.com/mhgrove/Empire)

Latest commit in repository: September 19, 2016

Not present in Maven central, need to clone sources and install into local repository.

Requires **Sesame 4.0.0**.

### Notes

It seems that Empire executes for each EM call a single transaction, so persisting a large number of instances results
in execution of a large number of transactions.
Trying to manage the transactions manually (through `em.getTransaction().begin/commit()`) leads to exceptions in Sesame client.
Have to explicitly register entity classes.