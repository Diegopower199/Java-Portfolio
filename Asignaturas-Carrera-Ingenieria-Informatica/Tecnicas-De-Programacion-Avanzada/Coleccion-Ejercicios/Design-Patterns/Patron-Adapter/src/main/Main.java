package main;

public class Main {
    private static Motor motorComun;
    private static Motor motorEconomico;
    private static Motor motorElectricoAdapter;

    public static void main(String[] args) {

        System.out.println("MotorComun");
        motorComun = new MotorComun();
        usarMotor(motorComun);

        System.out.println("\n\n\n--------------------------------------\nMotorEconomico\n");
        motorEconomico = new MotorEconomico();
        usarMotor(motorEconomico);

        System.out.println("\n\n\n--------------------------------------\nMotorElectricoAdapter\n");
        motorElectricoAdapter = new MotorElectricoAdapter();
        usarMotor(motorElectricoAdapter);
    }

    private static void usarMotor(Motor motorSeleccionado) {
        motorSeleccionado.encender();
        motorSeleccionado.acelerar();
        motorSeleccionado.apagar();
    }
}
