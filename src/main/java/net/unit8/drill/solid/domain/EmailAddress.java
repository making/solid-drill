package net.unit8.drill.solid.domain;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.constraint.CharSequenceConstraint;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validated;
import am.ik.yavi.core.Validator;
import am.ik.yavi.fn.Either;
import lombok.Value;

@Value
public class EmailAddress {
    private final static Validator<EmailAddress> validator = ValidatorBuilder.<EmailAddress>of()
            .constraint(EmailAddress::getDomain, "domain", c -> c
                    .notBlank()
                    .lessThanOrEqual(50))
            .constraint(EmailAddress::getLocalPart, "localPart", c -> c
                    .notBlank()
                    .lessThanOrEqual(50))
            .constraint(EmailAddress::toAddrSpecForm, "addrSpecForm", CharSequenceConstraint::email)
            .build();

    String localPart;
    String domain;

    private EmailAddress(String localPart, String domain) {
        this.localPart = localPart;
        this.domain = domain;
    }

    public static Validated<EmailAddress> of(String localPart, String domain) {
        EmailAddress email = new EmailAddress(localPart, domain);
        return validator.prefixed("email").applicative().validate(email);
    }

    public String toAddrSpecForm() {
        return localPart + "@" + domain;
    }

    public String toString() {
        return toAddrSpecForm();
    }
}
