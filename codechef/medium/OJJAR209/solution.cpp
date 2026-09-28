import styles from './styles.module.css';

function PriceDisplay({ price }) {
  console.log(`Rendering PriceDisplay with price: ${price}, key: ${price}`);

    return (
        <div className={styles.wrapper}>
              {/* Passing price as key re-triggers animation on value change */}
                    <div key={price} className={styles.animated}>
                            {'$ ' + price}
                                  </div>
                                      </div>
                                        );
                                        }

                                        export default PriceDisplay;