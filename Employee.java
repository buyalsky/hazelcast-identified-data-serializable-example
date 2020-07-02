import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

import java.io.IOException;

public class Employee implements IdentifiedDataSerializable {

    private String firstName;
    private String lastName;
    private int salaryPerMonth;
    private String companyName;

    public Employee(String firstName, String lastName, int salaryPerMonth, String companyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryPerMonth = salaryPerMonth;
        this.companyName = companyName;
    }

    @Override
    public int getFactoryId() {
        return 1;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeUTF(firstName);
        out.writeUTF(lastName);
        out.writeInt(salaryPerMonth);
        out.writeUTF(companyName);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        firstName = in.readUTF();
        lastName = in.readUTF();
        salaryPerMonth = in.readInt();
        companyName = in.readUTF();
    }
}

