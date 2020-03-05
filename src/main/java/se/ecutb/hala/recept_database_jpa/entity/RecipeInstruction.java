package se.ecutb.hala.recept_database_jpa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String instructionId;
    @Column(length = 1000)
    private String instructions;

    public RecipeInstruction( String instructions) {
        this.instructions = instructions;
    }

    public String getInstructionId() {
        return instructionId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecipeInstruction{");
        sb.append("instructionId='").append(instructionId).append('\'');
        sb.append(", instructions='").append(instructions).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
