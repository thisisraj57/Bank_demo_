import React, { useState } from 'react';

function TransferFunds() {
    const [recipient, setRecipient] = useState('');
    const [amount, setAmount] = useState('');
    const [useEmail, setUseEmail] = useState(true);
    const [confirmation, setConfirmation] = useState('');

    const validateEmail = (email) => {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    };

    const handleTransfer = () => {
        if (useEmail && !validateEmail(recipient)) {
            alert('Please enter a valid email address.');
            return;
        }

        // Simulate transfer processing
        setTimeout(() => {
            setConfirmation(`Transfer of $${amount} to ${recipient} was successful.`);
            // Here you would typically call an API to process the transfer
        }, 1000);
    };

    return (
        <div>
            <h2>Transfer Funds</h2>
            <div>
                <label>
                    <input
                        type="radio"
                        checked={useEmail}
                        onChange={() => setUseEmail(true)}
                    />
                    Use Email
                </label>
                <label>
                    <input
                        type="radio"
                        checked={!useEmail}
                        onChange={() => setUseEmail(false)}
                    />
                    Use Mobile Number
                </label>
            </div>
            <div>
                <label>
                    {useEmail ? 'Recipient Email:' : 'Recipient Mobile Number:'}
                    <input
                        type="text"
                        value={recipient}
                        onChange={(e) => setRecipient(e.target.value)}
                    />
                </label>
            </div>
            <div>
                <label>
                    Amount:
                    <input
                        type="number"
                        value={amount}
                        onChange={(e) => setAmount(e.target.value)}
                    />
                </label>
            </div>
            <button onClick={handleTransfer}>Transfer</button>
            {confirmation && <p>{confirmation}</p>}
        </div>
    );
}

export default TransferFunds;