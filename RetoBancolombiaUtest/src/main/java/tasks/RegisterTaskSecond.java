package tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.RegisterUserInterface.*;
import java.util.List;

import models.UserFirstFields;
import models.UserSecond;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.validator.routines.ISBNValidator;

public class RegisterTaskSecond implements Task {
    private List<UserSecond> data;

    public RegisterTaskSecond(List<UserSecond> data) {
        this.data=data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(data.get(0).getCityfield()).into(TXT_CITY),
                Click.on(TXT_CITY),
                Click.on(TXT_CITY_LIST),
                Enter.theValue(data.get(0).getZiporpostalcodefield()).into(TXT_POSTALCODE),
                Click.on(TXT_COUNTRY_LIST),
                WaitUntil.the(TXT_COUNTRY.of(data.get(0).getCountry()), isClickable()).forNoMoreThan(20).seconds(),
                Click.on(TXT_COUNTRY.of(data.get(0).getCountry())),
                Click.on(BTN_NEXTDEVICES)
        );
    }

    public static RegisterTaskSecond fields(List<UserSecond> data) {

        return Tasks.instrumented(RegisterTaskSecond.class,data);
    }



}
