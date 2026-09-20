using System;
using System.IO;

namespace SistemaVeterinario
{
    class Program
    {
        static void Main(string[] args)
        {
            int opcion = 0;
            do
            {
                Console.Clear();
                Console.WriteLine("========================================");
                Console.WriteLine("       SISTEMA VETERINARIO - MV         ");
                Console.WriteLine("========================================");
                Console.WriteLine("1. Registrar Mascota");
                Console.WriteLine("2. Ver Consultas Médicas");
                Console.WriteLine("3. Generar Diagnóstico de Entrega (Auditoría)");
                Console.WriteLine("4. Salir");
                Console.WriteLine("========================================");
                Console.Write("Seleccione una opción: ");

                if (int.TryParse(Console.ReadLine(), out opcion))
                {
                    switch (opcion)
                    {
                        case 1:
                            RegistrarMascota();
                            break;
                        case 2:
                            VerConsultas();
                            break;
                        case 3:
                            GenerarDiagnosticoEntrega();
                            break;
                        case 4:
                            Console.WriteLine("\nSaliendo del sistema...");
                            break;
                        default:
                            Console.WriteLine("\nOpción no válida. Intente de nuevo.");
                            PresioneContinuar();
                            break;
                    }
                }
                else
                {
                    opcion = 0;
                    Console.WriteLine("\nPor favor, ingrese un número válido.");
                    PresioneContinuar();
                }

            } while (opcion != 4);
        }

        static void RegistrarMascota()
        {
            Console.Clear();
            Console.WriteLine("--- REGISTRAR NUEVA MASCOTA ---");
            Console.Write("Nombre de la mascota: ");
            string nombre = Console.ReadLine();
            Console.Write("Especie (Perro, Gato, Ave, Reptil, etc.): ");
            string especie = Console.ReadLine();
            Console.WriteLine($"\n¡Mascota {nombre} ({especie}) registrada con éxito!");
            PresioneContinuar();
        }

        static void VerConsultas()
        {
            Console.Clear();
            Console.WriteLine("--- HISTORIAL DE CONSULTAS ---");
            Console.WriteLine("1. 12/08/2026 - Bobby (Perro) - Vacunación Anual.");
            Console.WriteLine("2. 25/08/2026 - Luna (Gato) - Control de Peso.");
            Console.WriteLine("3. 19/09/2026 - Yuyu (Perro) - Corte de pelo.");
            PresioneContinuar();
        }

        static void GenerarDiagnosticoEntrega()
        {
            Console.Clear();
            Console.WriteLine("--- GENERANDO DIAGNÓSTICO DE ENTREGA ---");

            string nombreArchivo = "auditoria_entrega.log";

            try
            {
                // Captura de datos del entorno de la MV usando System.Environment
                string maquina = Environment.MachineName;
                string sistemaOperativo = Environment.OSVersion.ToString();
                string usuario = Environment.UserName;
                string fechaHora = DateTime.Now.ToString("dd/MM/yyyy HH:mm:ss");

                // Construcción del contenido del archivo log
                using (StreamWriter writer = new StreamWriter(nombreArchivo, false))
                {
                    writer.WriteLine("==================================================");
                    writer.WriteLine("         AUDITORÍA DE ENTORNO DE ENTREGA          ");
                    writer.WriteLine("==================================================");
                    writer.WriteLine($"Nombre único de la VM : {maquina}");
                    writer.WriteLine($"Sistema Operativo VM  : {sistemaOperativo}");
                    writer.WriteLine($"Usuario de la VM      : {usuario}");
                    writer.WriteLine($"Fecha y Hora Ejecución: {fechaHora}");
                    writer.WriteLine("==================================================");
                }

                Console.WriteLine($"\n[ÉXITO] Archivo '{nombreArchivo}' creado correctamente.");
                Console.WriteLine("Se han capturado los datos de la Máquina Virtual.");
                
                // Mostrar en pantalla lo que se guardó
                Console.WriteLine("\nDatos guardados:");
                Console.WriteLine($"- VM: {maquina}");
                Console.WriteLine($"- OS: {sistemaOperativo}");
                Console.WriteLine($"- Usuario: {usuario}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\n[ERROR] No se pudo generar el archivo log: {ex.Message}");
            }

            PresioneContinuar();
        }

        static void PresioneContinuar()
        {
            Console.WriteLine("\nPresione cualquier tecla para continuar...");
            Console.ReadKey();
        }
    }
}
