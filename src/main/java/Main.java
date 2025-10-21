// interface imports
import interfaces.DataConverter;
import interfaces.FileReader;
import interfaces.FileWriter;
import interfaces.OperationHandler;
import interfaces.OperationStrategy;
import interfaces.ReportGenerator;
import interfaces.ShopService;
import interfaces.Storage;
// java imports
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// operations imports
import operations.BalanceOperation;
import operations.PurchaseOperation;
import operations.ReturnOperation;
import operations.SupplyOperation;
// Impl imports
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.FruitTransaction;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import service.impl.StorageDao;
// Strategy import
import strategy.OperationStrategyImpl;

public class Main {
    private static final String FILE_PATH = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        Storage storage = new StorageDao();
        FileReader reader = new FileReaderImpl();
        DataConverter converter = new DataConverterImpl();
        final FileWriter writer = new FileWriterImpl();

        final List<String> inputReport = reader.read(FILE_PATH);

        final List<FruitTransaction> transactions = converter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(storage));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        writer.write(resultingReport, FINAL_REPORT_PATH);
    }
}
