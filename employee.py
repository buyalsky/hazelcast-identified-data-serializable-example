import hazelcast
from hazelcast.serialization.api import IdentifiedDataSerializable


class Employee(IdentifiedDataSerializable):
    CLASS_ID = 1
    FACTORY_ID = 1

    def __init__(self, first_name=None, last_name=None, salary=None, company_name=None):
        self.first_name = first_name
        self.last_name = last_name
        self.salary = salary
        self.company_name = company_name

    def get_class_id(self):
        return self.CLASS_ID

    def get_factory_id(self):
        return self.FACTORY_ID

    def write_data(self, object_data_output):
        object_data_output.write_utf(self.first_name)
        object_data_output.write_utf(self.last_name)
        object_data_output.write_int(self.salary)
        object_data_output.write_int(self.company_name)

    def read_data(self, object_data_input):
        self.first_name = object_data_input.read_utf()
        self.last_name = object_data_input.read_utf()
        self.salary = object_data_input.read_int()
        self.company_name = object_data_input.read_utf()

    def __str__(self):
        return "Employee with Name: {}, LastName: {}, Salary: {}, CompanyName: {}".format(self.first_name,
                                                                                          self.last_name,
                                                                                          self.salary,
                                                                                          self.company_name)


if __name__ == "__main__":
    config = hazelcast.ClientConfig()

    # Register the custom Employee class to SerializationConfig.
    factory = {Employee.CLASS_ID: Employee}
    config.serialization_config.add_data_serializable_factory(Employee.FACTORY_ID, factory)

    client = hazelcast.HazelcastClient(config)

    my_map = client.get_map("map")

    keys = my_map.key_set().result()

    for key in keys:
        print("{} -> {}".format(key, my_map.get(key).result()))

    client.shutdown()
