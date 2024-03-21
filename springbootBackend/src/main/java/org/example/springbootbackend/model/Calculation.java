package org.example.springbootbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * The type Calculation.
 */
@Entity
@Table(name = "calculations")
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expression;
    private String result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


    // Constructors, getters, and setters

    /**
     * Instantiates a new Calculation.
     */
    public Calculation() {
    }

    /**
     * Instantiates a new Calculation.
     *
     * @param expression the expression
     * @param result     the result
     * @param user       the user
     */
    public Calculation(String expression, String result, User user) {
        this.expression = expression;
        this.result = result;
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets expression.
     *
     * @return the expression
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Sets expression.
     *
     * @param expression the expression
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
