package witchub.com.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Seller {

    @NotNull
    private int sellerId;

    private boolean isValid;
    private int wallet;
    private float demandRate;

    @NotEmpty
    private String accountNo;

    @NotEmpty
    private String bankName;

    @NotEmpty
    private String bankBranch;

    @NotEmpty
    private String ifscCode;

    // foreign key(s)
    private int userId;
}
