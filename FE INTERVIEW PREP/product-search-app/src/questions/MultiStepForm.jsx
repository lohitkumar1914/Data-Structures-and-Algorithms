import React, { useState } from "react";

const MultiStepForm = () => {
  const [step, setStep] = useState(1);
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    street: "",
    city: "",
  });

  const [errors, setErrors] = useState({});

  // Validation logic per step
  const validateStep = () => {
    const newErrors = {};
    if (step === 1) {
      if (!formData.name.trim()) newErrors.name = "Name is required.";
      if (!formData.email.trim()) newErrors.email = "Email is required.";
      else if (!/\S+@\S+\.\S+/.test(formData.email))
        newErrors.email = "Email is invalid.";
    } else if (step === 2) {
      if (!formData.street.trim()) newErrors.street = "Street is required.";
      if (!formData.city.trim()) newErrors.city = "City is required.";
    }
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleNext = () => {
    if (validateStep()) setStep((prev) => prev + 1);
  };

  const handleBack = () => setStep((prev) => prev - 1);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    alert("Form submitted successfully:\n" + JSON.stringify(formData, null, 2));
  };

  return (
    <div
      style={{ maxWidth: "500px", margin: "0 auto", fontFamily: "sans-serif" }}
    >
      <h2>Multi-Step Form Wizard</h2>
      <form onSubmit={handleSubmit}>
        {/* Step 1: Personal Info */}
        {step === 1 && (
          <div>
            <div>
              <label>Name:</label>
              <br />
              <input
                type="text"
                name="name"
                value={formData.name}
                onChange={handleChange}
              />
              {errors.name && <p style={{ color: "red" }}>{errors.name}</p>}
            </div>
            <div>
              <label>Email:</label>
              <br />
              <input
                type="email"
                name="email"
                value={formData.email}
                onChange={handleChange}
              />
              {errors.email && <p style={{ color: "red" }}>{errors.email}</p>}
            </div>
          </div>
        )}

        {/* Step 2: Address Info */}
        {step === 2 && (
          <div>
            <div>
              <label>Street:</label>
              <br />
              <input
                type="text"
                name="street"
                value={formData.street}
                onChange={handleChange}
              />
              {errors.street && <p style={{ color: "red" }}>{errors.street}</p>}
            </div>
            <div>
              <label>City:</label>
              <br />
              <input
                type="text"
                name="city"
                value={formData.city}
                onChange={handleChange}
              />
              {errors.city && <p style={{ color: "red" }}>{errors.city}</p>}
            </div>
          </div>
        )}

        {/* Step 3: Summary */}
        {step === 3 && (
          <div>
            <h3>Review Your Information:</h3>
            <p>
              <strong>Name:</strong> {formData.name}
            </p>
            <p>
              <strong>Email:</strong> {formData.email}
            </p>
            <p>
              <strong>Street:</strong> {formData.street}
            </p>
            <p>
              <strong>City:</strong> {formData.city}
            </p>
          </div>
        )}

        {/* Navigation Buttons */}
        <div style={{ marginTop: "20px" }}>
          {step > 1 && (
            <button
              type="button"
              onClick={handleBack}
              style={{ marginRight: "10px" }}
            >
              Back
            </button>
          )}
          {step < 3 && (
            <button type="button" onClick={handleNext}>
              Next
            </button>
          )}
          {step === 3 && <button type="submit">Submit</button>}
        </div>
      </form>
    </div>
  );
};

export default MultiStepForm;
