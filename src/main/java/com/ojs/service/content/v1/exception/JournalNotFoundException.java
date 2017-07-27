package com.ojs.service.content.v1.exception;


public class JournalNotFoundException extends RuntimeException {

    public JournalNotFoundException(long journalId) {
        super("journal not found for ID " + journalId);
    }
}
