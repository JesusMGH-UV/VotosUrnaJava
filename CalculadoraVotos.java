import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculadoraVotos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> urna = new HashMap<>();
        int totalVotos = 0;

        System.out.println("--- Sistema de Conteo de Votos ---");
        System.out.println("Ingrese el número del candidato (o '0' para finalizar):");

        while (true) {
            System.out.print("Ingrese voto: ");
            int voto = scanner.nextInt();

            if (voto == 0) {
                break;
            }
            if (voto < 0) {
                System.out.println("Número no válido. Intente de nuevo.");
                continue;
            }
            urna.put(voto, urna.getOrDefault(voto, 0) + 1);
            totalVotos++;
        }

        System.out.println("\n--- Resultados de la Urna ---");
        if (totalVotos == 0) {
            System.out.println("La urna está vacía.");
        } else {
            System.out.println("Total de votos: " + totalVotos);
            for (Map.Entry<Integer, Integer> entry : urna.entrySet()) {
                int candidato = entry.getKey();
                int votosCandidato = entry.getValue();
                double porcentaje = ((double) votosCandidato / totalVotos) * 100;
                System.out.printf("Candidato %d: %d votos (%.2f%%)%n", candidato, votosCandidato, porcentaje);
            }
        }
        scanner.close();
    }
}

