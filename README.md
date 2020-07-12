# hazelcast-identified-data-serializable-example

This repository contains a example to demonstrate how to serialize custom objects between Java and Python using IdentifiedDataSerializable.

#### Files:

1. Employee.java: This file contains our custom employee class for Java.
2. Demo.java: This file connects to the Hazelcast cluster and puts 3 Employees into a map.

3. employee.py: This file includes custom employee class for Python. It also reads items in the map that we put in Demo.java before.

Note that this example works with Hazelcast IMDG with version 3.12, since v4.0 and above not yet supported in Python Client.

Please see https://github.com/hazelcast/hazelcast-python-client#4-serialization for more available serialization options.
