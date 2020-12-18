package tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static userinterfaces.RegisterUserInterface.*;

import java.util.List;

import models.ThirdField;
import models.UserFirstFields;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


public class RegisterTaskThrid implements Task {
    private List<ThirdField> data;

    public RegisterTaskThrid(List<ThirdField> data) {
        this.data=data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_COMPUTER_lIST, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(TXT_COMPUTER_lIST),
                Click.on(TXT_COMPUTER.of(data.get(0).getComputer())),
                Click.on(TXT_VERSION_LIS),
                Click.on(TXT_VERSION.of(data.get(0).getVersionfield())),
                Click.on(TXT_LENGUAGEFIELD_LIST),
                Click.on(TXT_LENGUAGEFIELD.of(data.get(0).getLanguagefield())));
    }

    public static RegisterTaskThrid fields(List<ThirdField> data) {

        return Tasks.instrumented(RegisterTaskThrid.class,data);
    }




}
