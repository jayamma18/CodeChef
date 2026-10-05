
export function Temperature({ defaultTemperature = 0 }) {
  // State to store the current temperature value
    const [temperature, setTemperature] = useState(defaultTemperature);

      // State to track the current unit (Celsius or Fahrenheit)
        const [unit, setUnit] = useState("C");

          // Function to convert temperature between Celsius and Fahrenheit
            const convertTemperature = () => {
                if (unit === "C") {
                      setTemperature((temperature * 9) / 5 + 32);
                            setUnit("F");
                                } else {
                                      setTemperature(((temperature - 32) * 5) / 9);
                                            setUnit("C");
                                                }
                                                  };

                                                    return (
                                                        <div className={styles.wrapper}>
                                                              <h1>Temperature Converter</h1>
                                                                    <div className={styles.display}>
                                                                            {temperature.toFixed(2)}
                                                                                    <span>°{unit}</span>
                                                                                          </div>
                                                                                                <div className={styles.controls}>
                                                                                                        <button onClick={() => setTemperature(temperature + 1)}>Increase</button>
                                                                                                                <button onClick={() => setTemperature(temperature - 1)}>Decrease</button>
                                                                                                                        <button onClick={convertTemperature}>
                                                                                                                                  {unit === "C" ? "Convert to Fahrenheit" : "Convert to Celsius"}
                                                                                                                                          </button>
                                                                                                                                                </div>
                                                                                                                                                    </div>
                                                                                                                                                      );
                                                                                                                                                      }

                                                                                                                                                      export default function App() {
                                                                                                                                                        return <Temperature defaultTemperature={25} />;
                                                                                                                                                        }