package mx.financial.gatewaybff.handlers

import mx.financial.gatewaybff.models.ErrorCode
import org.springframework.context.support.MessageSourceAccessor

class ErrorCodeHandler(val accessor: MessageSourceAccessor) {

    operator fun get(code: String): ErrorCode {
        return ErrorCode(code, accessor.getMessage(code))
    }
}
