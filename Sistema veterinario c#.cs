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
                Console.WriteLine("2. Ver Consultas MÃ©dicas");
                Console.WriteLine("3. Generar DiagnÃ³stico de Entrega (AuditorÃ­a)");
                Console.WriteLine("4. Salir");
                Console.WriteLine("========================================");
                Console.Write("Seleccione una opciÃ³n: ");

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
                            Console.WriteLine("\nOpciÃ³n no vÃ¡lida. Intente de nuevo.");
                            PresioneContinuar();
                            break;
                    }
                }
                else
                {
                    opcion = 0;
                    Console.WriteLine("\nPor favor, ingrese un nÃºmero vÃ¡lido.");
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
            Console.WriteLine($"\nÂ¡Mascota {nombre} ({especie}) registrada con Ã©xito!");
            PresioneContinuar();
        }

        static void VerConsultas()
        {
            Console.Clear();
            Console.WriteLine("--- HISTORIAL DE CONSULTAS ---");
            Console.WriteLine("1. 12/08/2026 - Bobby (Perro) - VacunaciÃ³n Anual.");
            Console.WriteLine("2. 25/08/2026 - Luna (Gato) - Control de Peso.");
            Console.WriteLine("3. 19/09/2026 - Yuyu (Perro) - Corte de pelo.");
            PresioneContinuar();
        }

        static void GenerarDiagnosticoEntrega()
        {
            Console.Clear();
            Console.WriteLine("--- GENERANDO DIAGNÃ“STICO DE ENTREGA ---");

            string nombreArchivo = "auditoria_entrega.log";

            try
            {
                // Captura de datos del entorno de la MV usando System.Environment
                string maquina = Environment.MachineName;
                string sistemaOperativo = Environment.OSVersion.ToString();
                string usuario = Environment.UserName;
                string fechaHora = DateTime.Now.ToString("dd/MM/yyyy HH:mm:ss");

                // ConstrucciÃ³n del contenido del archivo log
                using (StreamWriter writer = new StreamWriter(nombreArchivo, false))
                {
                    writer.WriteLine("==================================================");
                    writer.WriteLine("         AUDITORÃA DE ENTORNO DE ENTREGA          ");
                    writer.WriteLine("==================================================");
                    writer.WriteLine($"Nombre Ãºnico de la VM : {maquina}");
                    writer.WriteLine($"Sistema Operativo VM  : {sistemaOperativo}");
                    writer.WriteLine($"Usuario de la VM      : {usuario}");
                    writer.WriteLine($"Fecha y Hora EjecuciÃ³n: {fechaHora}");
                    writer.WriteLine("==================================================");
                }

                Console.WriteLine($"\n[Ã‰XITO] Archivo '{nombreArchivo}' creado correctamente.");
                Console.WriteLine("Se han capturado los datos de la MÃ¡quina Virtual.");
                
                // Mostrar en pantalla lo que se guardÃ³
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
